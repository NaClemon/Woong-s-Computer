from selenium import webdriver
from bs4 import BeautifulSoup
import time
import re
import pandas as pd
import csv

def main():
    driver = webdriver.Chrome('/Users/choejaeung/Downloads/chromedriver')
    print('server-on')

    f = open('cpu1.csv', 'w', encoding='utf-8',newline='')
    wr = csv.writer(f)
    wr.writerow(['mb_id', '이름', '가격', '코어', '쓰레드', '속도','소켓','img_url1','img_url2'])

    # ------------정규표현식--------
    pattern4 = re.compile("[0-9]+")
    pattern_date = re.compile("[0-9]{4}-[0-9]+-[0-9]+")
    #pattern_manu = re.compile("'\('[가-힣]+'\)'")

    cpu_id = 3000
    for k in range(1,2):
        print('page' + str(k))
        driver.implicitly_wait(3)
        driver.get('http://www.enuri.com/list.jsp?cate=07070120')

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
            #print(price)
            core = spec_temp[2].text
            thread = spec_temp[3].text
            speed = spec_temp[4].text
            socket = spec_temp[6].text
            #print(core)
            #print(thread)
            #print(speed)
            #print(socket)

            img = str(k)
            cpu_img = re.sub("[a-z]|_", '', img)
            cpu_img_0 = cpu_img[0:5] + '000'
            cpu_url = 'http://photo3.enuri.com/data/images/service/img_300/' + cpu_img_0 + '/' + cpu_img + '.jpg'
            cpu_url2 = 'http://photo3.enuri.com/data/images/service/big/' + cpu_img_0 + '/' + cpu_img + '.jpg'
            wr.writerow([cpu_id,name,price,core,thread,speed,socket,cpu_url,cpu_url2])

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