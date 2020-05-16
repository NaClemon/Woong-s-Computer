from selenium import webdriver
from bs4 import BeautifulSoup
import time
import re
import pandas as pd
import csv

def main():
    driver = webdriver.Chrome('/Users/choejaeung/Downloads/chromedriver')
    driver.get('https://store.steampowered.com/login/?redir=&redir_ssl=1')
    print('server-on')

    f = open('mainboard.csv', 'w', encoding='utf-8',newline='')
    wr = csv.writer(f)
    wr.writerow(['mb_id', '이름', '지원_cpu', '규격', '소켓', '칩셋','img_url1','img_url2'])

    # ------------정규표현식--------
    pattern4 = re.compile("[0-9]+")
    pattern_date = re.compile("[0-9]{4}-[0-9]+-[0-9]+")
    #pattern_manu = re.compile("'\('[가-힣]+'\)'")

    mb_id = 4000
    for k in range(1,3):
        print('page' + str(k))
        driver.implicitly_wait(3)
        driver.get('http://www.enuri.com/list.jsp?cate=07080209&page=' + str(k))

        html = driver.page_source
        root = BeautifulSoup(html, 'html.parser')
        id_url = driver.find_elements_by_css_selector('div.cont_area > ul.goodList.listDataCont.simple_type> li')
        temp = item_id(id_url)
        driver.implicitly_wait(10)
        time.sleep(5)

        for k in temp:
            name = root.select('ul.goodList.listDataCont.simple_type > li#'+str(k)+' div.sp_title > strong.tit > a')[0].text
            spec_temp = root.select('div.info_area > div.summary > a')
            print(name)
            price_temp = root.select('ul.goodList.listDataCont.simple_type > li#'+str(k)+' div.sp_title div.case_price > dl.option > dd.groupModelItem > span.don.groupModelLink > b')[0].text
            price = re.sub(',',"",price_temp)
            intel = spec_temp[1].text
            size = spec_temp[2].text
            socket = spec_temp[3].text
            chipset = spec_temp[5].text

            img = str(k)
            mb_img = re.sub("[a-z]|_", '', img)
            mb_img_0 = mb_img[0:5] + '000'
            mb_url = 'http://photo3.enuri.com/data/images/service/img_300/' + mb_img_0 + '/' + mb_img + '.jpg'
            mb_url2 = 'http://photo3.enuri.com/data/images/service/big/' + mb_img_0 + '/' + mb_img + '.jpg'
            wr.writerow([mb_id,name,price,intel,size,socket,chipset,mb_url,mb_url2])
            print("ok")
            mb_id += 1

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