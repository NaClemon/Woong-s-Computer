from selenium import webdriver
from bs4 import BeautifulSoup
import time
import re
import pandas as pd


def main():
    driver = webdriver.Chrome('C:/Users/choi/Desktop/danawa/util/chromedriver.exe')
    driver.get('http://www.enuri.com/list.jsp?cate=070511&page=1')
    #html = driver.page_source
    #root = BeautifulSoup(html, 'html.parser')
    vga_id = 100001
    vga_rank =1
    result = []
    print('server')
    for k in range(1,2):
        print('page'+str(k))
        driver.implicitly_wait(3)
        driver.get('http://www.enuri.com/list.jsp?cate=070511&page='+str(k))
        html = driver.page_source
        root = BeautifulSoup(html, 'html.parser')
        driver.implicitly_wait(3)
        id_url = driver.find_elements_by_css_selector('div.cont_area > ul.goodList.listDataCont.simple_type> li')
        #temp = id_url[0].get_attribute('id')
        temp = item_id(id_url)
        for n in temp:
            #title = root.select('div.goods_list > div.listview_area ul#listBodyDiv > li#' + str(n) + ' a.detailMultiLink.prodName')[0].text
            #price_o = root.select('div.goods_list > div.listview_area ul#listBodyDiv > li#' + str(n) + ' div.case_price > dl > dd > span > b')[0].text
            spec = root.select('div.goods_list > div.listview_area ul#listBodyDiv > li#' + str(n) + ' div.info_area div.summary a')[4]
            #price = re.sub(',','',price_o)
            time.sleep(1)
            print(spec)
        driver.implicitly_wait(3)
        #print(temp)
        #lex = root.select('div.goods_list > div.listview_area ul#listBodyDiv > li#' + str(temp) + ' a.detailMultiLink.prodName')[0].text
       #lex2 = re.sub('1위 ','',lex)
        #print(lex2)

        driver.implicitly_wait(10)

    #articles = pd.DataFrame(result, columns=['vga_id', '제품명', '가격', '제조사', '모델', '메모리', 'vga_rank'])
    #articles.to_csv('vga_please.csv', encoding='ms949')
    #driver.quit()

def item_id(id_url):
    print('상품코드 획득')
    for a in id_url:
        item_id = a.get_attribute('id')
        if(item_id=='md_ad_lp_id'):
            continue
        elif(item_id == "ebay_cpc_item_id"):
            continue
        print(item_id)
        yield item_id
main()
