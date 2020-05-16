from selenium import webdriver
from bs4 import BeautifulSoup
import time
import re
import pandas as pd
import csv

def main():
    driver = webdriver.Chrome('/Users/choejaeung/Downloads/chromedriver')
    driver.get('https://store.steampowered.com/login/?redir=&redir_ssl=1')
    driver.implicitly_wait(10)
    time.sleep(2)
    driver.find_element_by_name('username').send_keys('pikachu9573857')
    time.sleep(4)
    driver.find_element_by_name('password').send_keys('')
    time.sleep(4)
    driver.find_element_by_xpath('//*[@id="login_btn_signin"]/button/span').click()
    print('server-on')

    f = open('game_tag_ttt2.csv', 'w', encoding='utf-8', newline='')
    wr = csv.writer(f)
    wr.writerow(['game_id', '이름', '태그'])

    # ------------정규표현식--------
    pattern4 = re.compile("[0-9]+")
    pattern_date = re.compile("[0-9]+년[0-9]+월[0-9]+")

    result = []
    # 코드 입력할 시간
    time.sleep(15)

    # 게임 아이디 시작값
    game_id = 1

    for page in range(5,6):
        print('page: ',str(page))
        for i in range(4,26):
            #time.sleep(2)
            driver.implicitly_wait(3)
            driver.get('https://store.steampowered.com/search/?filter=topsellers&page=' + str(page) + '&category1=998')
            driver.find_element_by_xpath(
                '//*[@id="search_result_container"]/div[2]/a[' + str(i) + ']/div[2]/div[1]/span').click()
            driver.implicitly_wait(3)
            html2 = driver.page_source
            root2 = BeautifulSoup(html2, 'html.parser')

            if (len(root2.select('div.agegate_text_container > h2')) != 0):
                print("성인 컨텐츠")
                driver.find_element_by_name('ageDay').click()
                time.sleep(1)
                driver.find_element_by_xpath('// *[ @ id = "ageDay"] / option[19]').click()
                time.sleep(1)
                driver.find_element_by_name('ageMonth').click()
                time.sleep(1)
                driver.find_element_by_xpath('//*[@id="ageMonth"]/option[12]').click()
                time.sleep(1)
                driver.find_element_by_name('ageYear').click()
                time.sleep(1)
                driver.find_element_by_xpath('//*[@id="ageYear"]/option[93]').click()
                time.sleep(1)
                driver.find_element_by_xpath('//*[@id="app_agegate"]/div[1]/div[3]/a[1]/span').click()
                time.sleep(1)
                html2 = driver.page_source
                root2 = BeautifulSoup(html2, 'html.parser')

            name_t = root2.select('div.apphub_HomeHeaderContent div.apphub_HeaderStandardTop div.apphub_AppName')
            if (len(name_t) == 0):
                continue
            else:
                name = name_t[0].text
                #tag_list = []
                tag_temp = root2.select('div.glance_ctn div.glance_ctn_responsive_right div.glance_tags_ctn.popular_tags_ctn > div.glance_tags.popular_tags a.app_tag')
                for tag in range(len(tag_temp)):
                    tag_t = tag_temp[tag].text
                    #tag_list.append(re.sub("\t|\n", "", tag_t))
                    tag_list = re.sub("\t|\n", "", tag_t)
                    if (tag_list == "앞서 해보기"):
                        continue
                    wr.writerow([game_id, name, tag_list])
                try:
                    print('[[[게임' + str(i) + '번 완료]]]' + name)
                    game_id +=1
                except:
                    print('[[[게임' + str(i) + '번 실패]]]' + name)
                    continue

    driver.execute_script('window.history.go(-1)')
    driver.quit()
    f.close()

main()