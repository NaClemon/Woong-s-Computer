from selenium import webdriver
from bs4 import BeautifulSoup
import time
import re
import csv
import pandas as pd


def main():
    driver = webdriver.Chrome('/Users/choejaeung/Downloads/chromedriver')
    #driver.get('http://www.enuri.com/list.jsp?cate=070510&tabType=1&page=1')
    vga_id = 1000
    print('server')

    #------------정규표현식--------
    pattern = re.compile("[0-9]+GB?")
    #pattern2 = re.compile(":?[0-9]+W이상")
    pattern3 = re.compile("[A-Z]{2}[0-9]{3,4}")

    f = open('vga.csv', 'w', encoding='utf-8', newline='')
    wr = csv.writer(f)
    wr.writerow(['vga_id', '이름', '가격', '제조사', '모델', '메모리', 'img_url1', 'img_url2'])
    #---------------------------

    for k in range(1,3):
        print('page'+str(k))
        driver.implicitly_wait(3)
        driver.get('http://www.enuri.com/list.jsp?cate=070511&tabType=1&page='+str(k))
        html = driver.page_source
        root = BeautifulSoup(html, 'html.parser')
        id_url = driver.find_elements_by_css_selector('div.cont_area > ul.goodList.listDataCont.simple_type> li')
        temp = item_id(id_url)
        driver.implicitly_wait(10)
        time.sleep(5)
        for n in temp:
            title = root.select('div.goods_list > div.listview_area ul#listBodyDiv > li#' + str(n) + ' a.detailMultiLink.prodName')[0].text
            price_o = root.select('div.goods_list > div.listview_area ul#listBodyDiv > li#' + str(n) + ' div.case_price > dl > dd > span > b')[0].text
            memory_temp = re.search(pattern,title)
            if(bool(memory_temp)==True):
                memory = re.findall(pattern,title)[0]
                memory = re.sub("[A-Z]",'',memory)
            else:
                memory = '수정 필요'
            title_t = re.sub('&nbsp;|\t|\n| ','',title)
            company = root.select('div.goods_list > div.listview_area ul#listBodyDiv > li#' + str(n) + ' span.etc_txt a.com.reSearch')[0].text
            price = re.sub(',','',price_o)

            #vga_img 획득
            img = str(n)
            vga_img = re.sub("[a-z]|_",'',img)
            vga_img_0 = vga_img[0:5]+'000'
            vga_url ='http://photo3.enuri.com/data/images/service/img_300/'+vga_img_0+'/'+vga_img+'.jpg'
            vga_url2 = 'http://photo3.enuri.com/data/images/service/big/' + vga_img_0 + '/' + vga_img + '.jpg'

            model_temp = re.search(pattern3, title_t)
            if(bool(model_temp)==True):
                model = re.findall(pattern3,title_t)[0]
                model = re.sub('[A-Z]','',model)
            else:
                model = '수정 필요'
            time.sleep(.2)
            wr.writerow([vga_id, title, price, company, model,memory, vga_url, vga_url2])
            print("ok")
            vga_id += 1

    driver.quit()
    f.close()


def item_id(id_url):
    print('상품코드 획득')
    for a in id_url:
        item_id = a.get_attribute('id')
        if(item_id=='md_ad_lp_id'):
            continue
        elif(item_id == "ebay_cpc_item_id"):
            continue
        #print(item_id)
        yield item_id
main()
