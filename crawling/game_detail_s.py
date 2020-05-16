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
    #time.sleep(4)
    driver.find_element_by_xpath('//*[@id="login_btn_signin"]/button/span').click()
    print('server-on')

    f = open('game_detail_final.csv', 'w', encoding='utf-8',newline='')
    wr = csv.writer(f)
    wr.writerow(['game_id', '이름', '가격', '출시날짜', '개발사', '배급사','게임 설명','img_url'])

    # ------------정규표현식--------
    pattern4 = re.compile("[0-9]+")
    pattern_date = re.compile("[0-9]{4}-[0-9]+-[0-9]+")

    result = []
    # 코드 입력할 시간
    time.sleep(16)

    # 게임 아이디 시작값
    game_id = 1

    for page in range(1,6):
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

            name_t = root2.select('div.apphub_HomeHeaderContent > div.apphub_HeaderStandardTop > div.apphub_AppName')
            if(len(name_t)==0):
                continue
            else:
                name = name_t[0].text

                # 게임 가격
                price_temp = root2.select(
                    'div.game_purchase_action > div.game_purchase_action_bg div.game_purchase_price.price')
                if (len(price_temp) != 0):
                    k = price_temp[0].text
                    price_t = re.sub("\t|\n|,", "", k)
                    if (bool(re.search(pattern4, price_t)) == True):
                        price = re.findall(pattern4, price_t)
                        price_g = price[0]
                    else:
                        price_g = "수정 필요"
                else:
                    price_g = "수정 필요"


                # 게임 개발사
                develop = root2.select('div.dev_row div#developers_list a')[0].text

                # 게임 배급사
                publish = root2.select('div.dev_row > div.summary.column a')[0].text


                # 게임 장르

                # 게임 설명
                contents_temp = root2.select('div.block div.rightcol > div.glance_ctn div.game_description_snippet')[-1].text
                contents = re.sub("\t|\n", "", contents_temp)
                #print(contents)

                # 출시 일자
                date_p = root2.select('div.user_reviews > div.release_date > div.date')
                if(len(date_p)==0):
                    date_set ="미출시"
                else:
                    date_temp = date_p[0].text
                    date_set = re.sub(" ", "", date_temp)

                time.sleep(.2)
                driver.implicitly_wait(5)
                # 게임 이미지

                game_img_temp = driver.find_elements_by_css_selector('div.rightcol > div.glance_ctn > div.game_header_image_ctn img')[0]
                game_img = game_img_temp.get_attribute('src')
                # print(game_img)
            try:
                wr.writerow([game_id, name, price_g, date_set, develop, publish, contents,game_img])
                print('[[[게임' + str(i) + '번 완료]]]' + name)
                game_id +=1
            except:
                print('[[[게임' + str(i) + '번 실패]]]' + name)
                continue

    driver.execute_script('window.history.go(-1)')
    driver.quit()
    f.close()

main()