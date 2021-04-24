import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FailureRate {
    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        String a;

        Pair[] pairs = new Pair[N];

        for (int i = 0; i < N ; i++) {
            pairs[i] = new Pair(i+1);
        }

        int remainPerson = stages.length;
        int failedPerson = 1;
        for (int i = 0; i < stages.length ; i++) {
            int stage = stages[i];
            if(stage == N+1)
                continue;
            if(i == stages.length -1){
                failedPerson++;
                pairs[stage-1].stage = stage;
                pairs[stage-1].failure = (double) failedPerson / remainPerson;
                break;
            }
            if(stage == stages[i+1]) {
                failedPerson++;
                continue;
            }

            pairs[stage-1].stage = stage;
            pairs[stage-1].failure = (double)failedPerson / remainPerson;
            remainPerson -= failedPerson;
            failedPerson = 1;

        }

        Arrays.sort(pairs);


        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = pairs[i].stage;
        }

        return answer;
    }


}
class Pair implements Comparable<Pair> {
    int stage = 0;
    double failure = 0;

    public Pair(int stage) {
        this.stage = stage;
    }

    @Override
    public int compareTo(Pair p) {
        if( this.failure < p.failure){
            return 1;
        }
        else if(this.failure == p.failure){
            return this.stage - p.stage;
        }
        else
            return -1;
    }
}
