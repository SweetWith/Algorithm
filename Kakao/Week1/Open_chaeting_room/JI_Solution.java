import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChattingRoom {
    public String[] solution(String[] record) {

        List<Cmd> cmds = new ArrayList<>();
        Map<String,String> strMap = new HashMap<>();
        for (int i = 0; i < record.length ; i++) {
            Cmd tempCmd = new Cmd(record[i].split(" "));
            if (tempCmd.name != null) {
                strMap.put(tempCmd.id, tempCmd.name);
            }
            cmds.add(tempCmd);
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < cmds.size(); i++) {
            if (cmds.get(i).op.equals("Enter")) {
                ans.add(strMap.get(cmds.get(i).id)+"님이 들어왔습니다.");
            } else if(cmds.get(i).op.equals("Leave")) {
                ans.add(strMap.get(cmds.get(i).id)+"님이 나갔습니다.");
            }
        }

        String[] answer = new String[ans.size()];
        
        return ans.toArray(answer);
    }

    class Cmd{
        String op;
        String id;
        String name;

        public Cmd(String[] tempStrs) {
            this.op = tempStrs[0];
            this.id = tempStrs[1];
            if(tempStrs.length == 3){
                this.name = tempStrs[2];
            }
        }
    }

}
