
public class TodayEval {
    private String goodThgs;  //잘한점
    private String badThgs;   // 아쉬운점
    private int score; //점수
    private String date; //날짜

    public String getGoodThgs() {
        return goodThgs;
    }

    public void setGoodThgs(String goodThgs) {
        this.goodThgs = goodThgs;
    }

    public String getBadThgs() {
        return badThgs;
    }

    public void setBadThgs(String badThgs) {
        this.badThgs = badThgs;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    //오늘의 기록이 모두 입력 되었는지 여부 확인
    public boolean isValid() {
        if (goodThgs == null || badThgs == null || score == 0) {
            return false;
        } else
            return true;
    }

    //잘한점 아쉬운점 점수 리셋
    public void reset() {
        goodThgs = null;
        badThgs = null;
        score = 0;
    }
}
