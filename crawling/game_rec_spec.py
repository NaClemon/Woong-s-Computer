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

    f = open('game_genre.csv', 'w', encoding='utf-8', newline='')
    wr = csv.writer(f)
    wr.writerow(['game_id', '이름', '장르'])

    # ------------정규표현식--------
    pattern4 = re.compile("[0-9]+")
    pattern_date = re.compile("[0-9]{4}-[0-9]+-[0-9]+")

    result = []
    # 코드 입력할 시간
    time.sleep(15)

    # 게임 아이디 시작값
    game_id = 1

    for page in range(1,6):
        print('page: ',str(page))
        for i in range(1,26):
            time.sleep(2)
            driver.implicitly_wait(3)
            driver.get('https://store.steampowered.com/search/?filter=topsellers&page=' + str(page) + '&category1=998')
            driver.find_element_by_xpath(
                '//*[@id="search_result_container"]/div[2]/a[' + str(i) + ']/div[2]/div[1]/span').click()
            driver.implicitly_wait(10)
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
                genre = root2.select('div.block_content > div.block_content_inner > div.details_block > a')
                for k in range(len(genre)):
                    genre_t = genre[k].text
                    genre_temp = re.sub("\t|\n| ","",genre_t)
                    if(genre_temp=='웹사이트방문'):
                        break
                    wr.writerow([game_id, name, genre_temp])
                    #print(genre_temp)
                print(str(page),',',str(i),name)
                time.sleep(.1)

                #try:
                 #   wr.writerow([game_id, name, genre])
                  #  print('[[[게임' + str(i) + '번 완료]]]' + name)
                   # game_id +=1
                #except:
                 #   print('[[[게임' + str(i) + '번 실패]]]' + name)
                  #  continue

    driver.execute_script('window.history.go(-1)')
    driver.quit()
    f.close()

main()