from selenium import webdriver
from bs4 import BeautifulSoup
import time
import re
import pandas as pd
import csv

def main():
    driver = webdriver.Chrome('/Users/choejaeung/Downloads/chromedriver')
    print('server-on')

    f = open('case.csv', 'w', encoding='utf-8',newline='')
    wr = csv.writer(f)
    wr.writerow(['ram_id', '이름', '가격','회사' ,'type', 'case', 'img_url1','img_url2'])

    # ------------정규표현식--------
    pattern4 = re.compile("[0-9]+")
    pattern_date = re.compile("[0-9]{4}-[0-9]+-[0-9]+")
    #pattern_manu = re.compile("'\('[가-힣]+'\)'")
    pattern_5 = re.compile("^[A-Z]*[가-힣]*")

    cpu_id = 7000
    for k in range(1,3):
        print('page' + str(k))
        driver.implicitly_wait(3)
        driver.get('http://www.enuri.com/list.jsp?cate=071104&tabType=1&page='+str(k))

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
            price_temp = root.select('ul.goodList.listDataCont.simple_type > li#'+str(k)+' div.sp_title div.case_price > dl.option > dd.groupModelItem > span.don.groupModelLink > b')
            price_1 = price_temp[0].text
            price1 = re.sub(',',"",price_1)

            case = spec_temp[0].text
            mainboard = spec_temp[1].text
            company = root.select('ul.goodList.listDataCont.simple_type > li#'+str(k)+' div.info_area > span.etc_txt a.com.reSearch')[0].text

            img = str(k)
            ram_img = re.sub("[a-z]|_", '', img)
            ram_img_0 = ram_img[0:5] + '000'
            ram_url = 'http://photo3.enuri.com/data/images/service/img_300/' + ram_img_0 + '/' + ram_img + '.jpg'
            ram_url2 = 'http://photo3.enuri.com/data/images/service/big/' + ram_img_0 + '/' + ram_img + '.jpg'
            wr.writerow([cpu_id,name,price1,company,case,mainboard,ram_url,ram_url2])

            #print(spec_temp)
            print("ok")
            cpu_id += 1

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