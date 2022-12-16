# R + MongoDB 연동하기

# 1. 패키지 설치하기
install.packages("mongolite")

library(mongolite)
library(tidyverse)
library(dplyr)
library(ggmap)
library(ggplot2)
#3. mongodb server ON!
#4. mongodb connection
# 접속 관련 함수로 현재 실행되어있는 mongoDB와 연결

con <- mongolite::mongo(collection= "exams", 
                        db="nov28", 
                        url="mongodb://localhost",
                        verbose = TRUE, # 함수 수행시 발생하는 정보들을 자세히 보겠다.
                        options = ssl_options()) # 접속시에 보안 설정

con

#5. 기존 collection 삭제
# 기존 collection이 있는 경우 삭제
if (con$count() > 0) con$drop()

# 6. csv 파일 불러오기
# file로 첨부한 csv는 data.frame으로 로딩
exams <- read.csv("C:/Users/user/Desktop/R/sample/exams.csv", encoding="UTF-8") %>% tibble()

# tibble() : 데이터프레임으로 만들어주는 함수인데, 처음 10개의 행만 보여주는 기능을 해줌
exams

# 7. document 삽입
# 다른 r-mongodb 연동하는 패키지는
# document 삽입 시 json으로 포멧을 해야하지만,
# mongolite의 경우에는 insert()가 내부적으로 자동 json변환, 포맷이 가능

con$insert(exams)

# mongodb에서 확인
# use nov28 -> db.exams.find().pretty()

# document 확인
# 원래 data.frame 개수 = db에 있는 데이터
dim(exams)[1]
con$count()

# 8. db에 있는 document 받아오기
# 원래 data.frame (=exams)에 있는 데이터를
# 삭제
rm(exams)
exams

# 새로 exams를 만들어서 mongoDB에 있는 데이터를 import
exams <- con$find(query='{}')

dim(exams)
exams %>% head()

# 성별이 여자, 수학 44점, 읽기 55점인 사람의 데이터 조회
she <- con$find(query = '{"gender":"female", "math_score": 44, "reading_score": 55}')
she

# data update
# con$update()
# 성별이 여자, 수학 44점, 읽기 55점인 사람 -> 소속 그룹을 'group A'로 변경
exams <- con$update(query = '{"gender":"female", "math_score": 44, "reading_score": 55}',
                    update = '{
                    "$set":{"race_ethnicity":"group A"}}')

rm(exams)

she <- con$find(query = '{"gender":"female", "math_score": 44, "reading_score": 55}')
she
#-----------------------------------------------------------------------------------------
# 9. 조건으로 document 찾기
# Regular Expresiing (정규식) (regex)

# gender 변수의 값에 'f'가 포함되어있는 데이터 조회

shes <- con$find(query='{"gender": {"$regex": "f"}}')
shes

# MongoDB 문자열 검색
# 포함되어 있는지 확인 : {"$regex": "문자열"}
# 특정한 단어로 시작하는지 : {"$regex": "^문자열"}
# 특정한 단어로 끝나는지 : {"$regex": "문자열$"}
# 대소문자를 구분 >> 구분없이 찾고 싶다 :
#   {"$regex": "문자열"}, "$options":"i"

exams <- con$find(query='{}')
dafr <- data.frame(exams)
View(dafr)

# 이 데이터를 활용해서 <- 그룹별 수학 평균점수를 -> bar 그래프로 표현 (ggplot)
color =rainbow(5)
dafr_avg <- dafr %>% 
  group_by(race_ethnicity) %>% 
  summarise(math_mean = mean(math_score))

dafr_avg %>% 
ggplot(aes(x=race_ethnicity,y=math_mean)) + 
  geom_bar(stat = "identity", fill = color)
  #geom_col(fill="skyblue")

install.packages("echarts4r")
library(echarts4r)

# exams 데이터 -> 성별을 기준으로 그룹화 -> 각 통계 수치 얼마나 되는지 console 출력
exams %>% 
  group_by(gender) %>% 
  summarise(n=n()) %>% 
  e_chart(gender) %>% 
  e_bar(n, barwidth=10) %>% 
  e_tooltip(trigger = c("axis"))
    



# 접속 해제 : 해제에 대한 명령어가 딱히 없어서...
#           접속에 대한 것을 제거하는 느낌으로 (rm= remove)
rm(con)

















