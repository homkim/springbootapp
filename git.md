![](https://t1.daumcdn.net/cfile/tistory/1322BD4D4D7496720C)

## 기본 개념
매번 헷갈려서 정리함  

로컬에서 작업하다가 add 하면 index에 추가되고  
이를 커밋하면 local repository에 반영됨  
이걸 push하면 원격저장소에 반영됨

## error: src refspec master does not match any

해당 에러는 깃허브에서 pull 없이 push할 경우 기존 내용을 삭제하거나 하는 문제가 생길 수 있기 때문에, 이런 문제를 피하고자 에러 메세지를 발생시키는 것. 해당 에러가 발생하면 아래의 순서대로 다시 명령어를 입력한다. 

새로운 깃 리파지토리를 init하고, 다시 push 하는 방법이다.

git init

git add .

git commit -m "message"

커밋과 메세지를 넣으면 다음과 같이 Git 이름과 이메일을 입력하라고 하는데 다음과 같은 순서로 입력해주면 된다. 이름과 이메일 입력후 다시 Push를 하면 문제없이 Git에 업데이트 완료.

git config user.name "이름"

git config user.email "이메일"

git remote add origin "https://github.com/repository_name.git"

git push -u origin master  # origin 원격저장소의 마스터브랜치에 푸시

 

이후 새로운 내용이 추가되거나 수정되었을 때 다음과 같은 순서로 입력하면 문제없이 push 된다.

git add . (또는 특정 파일이나 폴더)

git commit -m "message"

git push -u origin master



