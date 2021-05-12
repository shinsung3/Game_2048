# Game_2048

- 목차
  - [1. 게임방법](#게임-방법)
  - [2. java 설명](#java-설명)
  - [3. 이미지 참고](#이미지-참고)



## 게임 방법

1. eclipse 실행
2. PennDraw를 이용하여 
3. **`사용방법`**
   - **a : 오른쪽 (right)**
   - **s : 아래 (down)**
   - **d : 왼쪽 (left)**
   - **w : 위 (up)**



## Java 설명
- MoveMap.java
  - 좌표 Object
  - Getter / Setter
- PennDraw.java
  - GUI
  - 출처 : uppen (펜실베니아 주립대학교 API)
- Draw2048.java
  - Main Method
  - 화면 그리기용
- Game.java
  - 각종 Game내에 필요한 기능 모음



## 세부 Java 설명

### 1. MoveMap.java

1. **`row`** - row (행)
2. **`col`** - column (열)
3. **`value`** - map(row, col)
4. **`checked`** - 한번 변했 값이 한판에 두번 변할 수는없으니 체크해야 함. (Boolean)
5. **`public MoveMap(int row, int col)`** - 좌표만 담아 줄 생성자 (Constructor)
6. **`public MoveMap(int row, int col, int value, boolean checked)`** - 좌표, value, check 값 추가
7. 그 외 getter/setter



### 2. PennDraw.java

- UPenn(펜실베니아 주립대학교) 오픈 소스

- StdDraw 기반

- 아래는 내가 사용 할 method들

  1.  **` public static void setPenColor(int red, int green, int blue)`**

     - RGB 색을 지정하여 화면의 글자나 배경의 색을 지정할 수 있다.

  2. **`public static void filledSquare(double x, double y, double r)`**

     - 각 네모 칸마다 색을 변경하고 만들어 줄것.

  3. **`public static void line(double x0, double y0, double x1, double y1)`**

     - 네모 칸 말고 16개의 칸을 나눠주기 위해서 먼저 선을 그려줌

  4. **`public static void setPenRadius(double r)`**

     - 라인을 그린 뒤 그 라인의 펜의 두께를 지정해준다.

  5. **`public static void text(double x, double y, String s)`**

     - 텍스트 위에 좌표에 맞게 문자(우리는 숫자들)를 나타내기 위한 용도

  6. **`public static void setFontSize(double pointSize)`**

     - 보이는 글자가 너무 작으면 안되니까 FontSize도 지정해준다.

  7. **`public static boolean hasNextKeyTyped()`**

     - 키를 눌렀는지 (블럭을 움직였는지 확인) - Return Type : boolean

  8.  **`public static char nextKeyTyped()`**

     - 어떤 키를 눌렀는지 확인 - Return Type : char

  9. **`public static void picture(double x, double y, String s)`**

     - 마지막으로 게임의 승패를 가를 수 있는 정보를 이미지로 뿌려 줄 예정.

     






## 이미지 참고

**기본 시작 화면**

- ![image](https://user-images.githubusercontent.com/46014771/117570061-b4b96800-b103-11eb-932e-1ad777426f9d.png)


- 오른쪽(a : right)
- ![image](https://user-images.githubusercontent.com/46014771/117570066-bf73fd00-b103-11eb-9e02-3865cfcc7afe.png)
- 아래(s : down)
- ![image](https://user-images.githubusercontent.com/46014771/117570069-c7cc3800-b103-11eb-9af7-e1a8c2cb0055.png)
- 왼쪽(d : left)
- ![image](https://user-images.githubusercontent.com/46014771/117570075-d155a000-b103-11eb-8283-ff52acaeaf6a.png)
- 위(w : up)
- ![image](https://user-images.githubusercontent.com/46014771/117570081-da467180-b103-11eb-8378-5cf4fe9334a6.png)