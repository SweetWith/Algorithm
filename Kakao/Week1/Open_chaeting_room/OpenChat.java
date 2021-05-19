package Kakao.Week1.Open_chaeting_room;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class OpenChat {
    public static void main(String[] args) {
        
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] answer = solution(record);

        for(int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        Map<String, String> user = new HashMap<String, String>();

        for(int i = 0; i < record.length; i++) {
            String val = record[i];
            String[] temp = val.split(" ");

            if("Enter".equals(temp[0])) {
                user.put(temp[1], temp[2]);
            } else if("Change".equals(temp[0])) {
                user.put(temp[1], temp[2]);
            }   
        }

        for(int i = 0; i < record.length; i++) {
            String val = record[i];
            String[] temp = val.split(" ");

            if("Enter".equals(temp[0])) {
                answer.add(user.get(temp[1]) + "님이 들어왔습니다.");
            } else if("Leave".equals(temp[0])) {
                answer.add(user.get(temp[1]) + "님이 나갔습니다.");
            }
        }

        return answer.toArray(new String[answer.size()]);
    }
}
