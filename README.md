# spring MVC 프로젝트를 사용한 CRUD-게시판
## 프로젝트 소개
spring MVC 프로젝트를 사용하여 Create, Read, Update, Delete 기능을 가진 게시판을 구현한 프로젝트입니다.

## 프로젝트 기간
2025.01.01 ~ 2025.01.07

## DB 테이블
![image](https://github.com/user-attachments/assets/83881c3b-7a59-478b-9203-5dac4e5a55d5)

이 테이블은 게시판 기능에서 사용되며, 게시글 번호, 제목, 내용, 작성자, 작성일, 수정일을 저장합니다.

# 구현
## 게시판 페이지
![image](https://github.com/user-attachments/assets/cb448515-82f9-4f5f-b4ea-0d73389ffefb)

게시판 페이지에선 게시글 등록, 게시글 목록 확인, 검색 기능을 이용할 수 있습니다.

## 게시글 검색 기능
![image](https://github.com/user-attachments/assets/6e171e1a-113e-4c2b-835a-2d9fd8e1045f)

검색 기능에선 여러 옵션을 통해 사용자가 원하는 게시물을 검색할 수 있도록 필터링 기능을 적용하였습니다.

![image](https://github.com/user-attachments/assets/6d38bcb2-304d-4d04-a2fd-cc177024dd20)
## 게시글 등록 기능
![image](https://github.com/user-attachments/assets/e34d9ca5-799a-427a-bd28-94e092b09376)

게시글 등록 기능에선 사용자가 원하는 제목, 내용, 작성자를 입력하고 등록 버튼을 누르면 게시글이 등록되도록 구현하였습니다.

## 등록된 게시글 확인 기능
![image](https://github.com/user-attachments/assets/451627ee-d9b9-4d03-b455-9060232a643b)

게시글이 정상적으로 등록되면 alert창으로 게시글이 등록되었다고 출력하고 게시판 페이지에서 등록된 글을 확인할 수 있도록 구현하였습니다.

## 게시글 상세보기 기능
![image](https://github.com/user-attachments/assets/27b3c1cf-c32d-4a17-96db-4a3dfabedcd8)

게시글 제목을 클릭하게 되면 게시글 상세보기 페이지로 이동을 하며 작성된 게시글을 확인할 수 있으며 아래 수정 버튼과 삭제 버튼까지 구현하였습니다.
댓글 기능은 추후에 구현 예정입니다.

## 게시글 수정 기능
![image](https://github.com/user-attachments/assets/c06c1441-5f15-4eef-af2b-1a09d0d813c1)

수정 버튼을 누르게 되면 게시글 수정 페이지로 이동을 하며 내용을 수정 후 수정완료 버튼을 누르면 게시글을 수정할 수 있도록 구현하였습니다.

## 수정된 게시글 확인 기능 
![image](https://github.com/user-attachments/assets/6d73481b-ba57-42b6-8c12-2c91af1e4b0a)

게시글이 정상적으로 수정되면 alert창으로 게시글이 수정되었다고 출력하고 게시판 페이지에서 수정된 글을 확인할 수 있도록 구현하였습니다.

## 게시글 삭제 기능 
![image](https://github.com/user-attachments/assets/4fb6b5ae-5c92-4405-a1e2-ba954fc17055)

삭제 버튼을 누르게 되면 게시판 페이지로 이동을 하며 게시판 페이지에서 게시글이 정상적으로 삭제된 것을 확인할 수 있도록 구현하였습니다.

## 페이지네이션 기능 구현
![image](https://github.com/user-attachments/assets/8255cbcc-a65d-4736-a755-0b26b283c09c)
![image](https://github.com/user-attachments/assets/6f030579-5ecb-474d-ba67-2da102d284da)

게시글은 한 페이지당 10개씩 출력되도록 구현하였으며 다른 페이지로 이동시 pagenum의 파라미터 값이 변경되게 구현하였습니다.
