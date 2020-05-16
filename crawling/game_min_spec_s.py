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
    driver.find_element_by_xpath('// *[ @ id = "login_btn_seignin"] / button / span').click()
    print('server-on')

    f = open('game_min_spec_temp4.csv', 'w', encoding='utf-8', newline='')
    wr = csv.writer(f)
    wr.writerow(['game_id', '이름', '운영체제', '프로세서', '메모리', '그래픽'])

    # ------------정규표현식--------
    pattern4 = re.compile("[0-9]+")
    pattern_date = re.compile("[0-9]{4}-[0-9]+-[0-9]+")

    result = []
    # 코드 입력할 시간
    time.sleep(30)

    # 게임 아이디 시작값
    game_id = 1

    for page in range(3,4):
        print('page: ',str(page))
        for i in range(14,26):
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

                # 게임 사양 최소만 있는 경우
                process3 = root2.select('div.sysreq_contents > div.game_area_sys_req.sysreq_content.active > div.game_area_sys_req_full ul ul.bb_ul li')
                if (len(process3) != 0):
                    speclist3 = []
                    for n in range(len(process3)):
                        process3_re = re.sub("운영체제: |프로세서: |그래픽: |메모리: |네트워크: |저장공간: |DirectX: ", "", process3[n].text)
                        if (process3_re == 'Broadband Internet connection'):
                            continue
                        speclist3.append(process3_re)
                    if (speclist3[0] == '64비트 프로세서와 운영 체제가 필요합니다'):
                        del speclist3[0]
                    else:
                        continue
                    if (len(speclist3) >= 4):
                        k = len(speclist3) - 4
                        for num in range(1, k + 1):
                            del speclist3[-1]
                    # print(speclist3)
                elif(len(process3)==0):
                    # 게임 사양(최소)
                    speclist3 = []
                    process3 = root2.select('div.sysreq_contents > div.game_area_sys_req.sysreq_content.active > div.game_area_sys_req_leftCol ul ul.bb_ul li')
                    for n in range(len(process3)):
                        process3_re = re.sub("운영체제: |프로세서: |그래픽: |메모리: |네트워크: |저장공간: |DirectX: ", "", process3[n].text)
                        if (process3_re == 'Broadband Internet connection'):
                            continue
                        speclist3.append(process3_re)
                    if (speclist3[0] == '64비트 프로세서와 운영 체제가 필요합니다'):
                        del speclist3[0]
                    if (len(speclist3) >= 4):
                        k = len(speclist3) - 4
                        for num in range(1, k + 1):
                            del speclist3[-1]
                time.sleep(.5)
                try:
                    wr.writerow([game_id, name, speclist3[0], speclist3[1], speclist3[2], speclist3[3]])
                    print('[[[게임' + str(i) + '번 완료]]]' + name)
                    game_id +=1
                except:
                    print('[[[게임' + str(i) + '번 실패]]]' + name)
                    continue

    driver.execute_script('window.history.go(-1)')
    driver.quit()
    f.close()

main()