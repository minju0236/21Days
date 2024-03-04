import java.util.Calendar;

public class Data {
    private String goal; //목표
    private TodayEval[] evals = new TodayEval[21]; //21개 일자의 기록 보관

    public Data() {
        Calendar date = Calendar.getInstance();

        for(int i=0; i < 21; i++) {
            evals[i] = new TodayEval();
            int year = date.get(Calendar.YEAR);
            int month = date.get(Calendar.MONTH) + 1;
            int day = date.get(Calendar.DAY_OF_MONTH);
            evals[i].setDate(year + "-" + month + "-" + day);
            date.add(Calendar.DATE, 1);
        }
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public TodayEval[] getEvals() {
        return evals;
    }

    //특정 일의 기록 가져오기
    public TodayEval getTodayEval(int day) {
        int index = day - 1;
        return evals[index];
    }

    //특정 날짜의 기록 가져오기
    public TodayEval getTodayEval(String date) {
        for(int i=0; i < evals.length; i++) {
            if (evals[i].getDate().equals(date)) {
                return evals[i];
            }
        }
        return null;
    }

    //목표달성점수의 평균 구하기
    public double getAvg() {
        double sum = 0;
        int count = 0;
        for(int i=0; i < evals.length; i++) {
            if (evals[i].getScore() > 0) {
                sum += evals[i].getScore();
                count++;
            }
        }
        if(count == 0) {
            return 0;
        } else {
            return (Math.round(sum*10 / count)/10.0);
        }
    }

    //목표 및 시간 리셋
    public void reset() {
        goal = null;
        for(int i=0; i < evals.length; i++) {
            evals[i].reset();
        }
    }

}
