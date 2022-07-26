public class DiaryTest {
    public static void main(String[] args) {
        Diary penzuDiary = new Diary();
        try{
            penzuDiary.welcomePage();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
