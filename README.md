# 발견 문제점
## 1. 서버 가동시 com.lec.spring.WriteDTO 오류
> **문제점** : 서버를 가동을 했는데 com.lec.spring.WriteDTO에서 오류가 발생되어서 서버 가동 오류가 발생함
> 
> **이유** : WriteDAO.xml에 com.lec.spring.WriteDTO를 찾질 못하기 때문에 오류가 발생되었음
> 
> **수정** : "com.lec.spring.WriteDTO"  => "com.lec.spring.domain.WriteDTO" 로 정확한 경로 설정

## 2. db 연결 문제
> **문제점** : 서버와 db를 연결해야하지만 db에서 문제가 생겨 오류가 발생됨
> 
> **이유** : db에 있는 db계정명을 없는 계정명으로 작성을 해서 오류가 발생을 함
> 
> **수정** : applicatoin.properties 에서 
> 1. spring.datasource.url=jdbc:mysql://localhost:3306/mydb?     =>  spring.datasource.url=jdbc:mysql://localhost:3306/mydb720?
> 2. spring.datasource.username=myuser  =>   spring.datasource.username=myuser720

## 3. 수정하고 나서 view를 제대로 못불러옴
> **문제점** : 수정을 하고 나서 해당된 view를 불러와야 하지만 id 값을 못불러옴
> 
>  **이유** : updateOk.jsp에서 해당된 uid값을 못받아와서 오류가 발생을 함
> 
> **수정** : location.href = "view.do?uid=${uid}";  => location.href = "view.do?uid=${param.uid}";

## 4. 뷰에서 삭제를 누르면 삭제가 안됨
> **문제점** : 뷰에서 삭제를 눌르면 삭제 성공이 떠야 하지만 uid를 못찾아서 삭제가 안된다.
> 
>  **이유** : WriteDAO.xml에 DELETE에 있는 잘못된 칼럼을 받아서 오류가 발생을 함
> 
> **수정** : DELETE FROM test_write WHERE uid = #{uid} = > DELETE FROM test_write WHERE wr_uid = #{uid}