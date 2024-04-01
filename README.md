### GDSC-Study-Assignment-Checker

GDSC Hongik의 개발 입문 스터디 과제 검수를 위한 프로그램입니다.  
application.properties 파일에 아래와 같이 정보를 입력해주시면 됩니다.

```properties
wilPrefix = https://raw.githubusercontent.com/%s
wilPostfix = /%s/main/Week%s/WIL%s.md
inputFilePath = {깃허브 핸들을 모아둔 txt 파일의 경로}
outputFilePath = {과제 검사 통과자의 WIL url을 저장할 파일의 경로}

week = {주차}
numberOfWil= {WIL 번호}
studyName = {repository 이름}
```


inputFile은 수강생들의 깃허브 핸들을 한 줄에 하나씩 적어둔 txt 파일입니다.  
아래는 inputFile의 예시입니다.
```text
Sangwook02
Alice
Bob
Charlie
```