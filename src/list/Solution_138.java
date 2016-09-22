package list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiyuanbupt on 9/22/16.
 */
public class Solution_138 {

    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        return deepCopy(head,map);

    }

    private RandomListNode deepCopy(RandomListNode head,Map<RandomListNode,RandomListNode> map){
        if(head == null)return head;
        if(map.containsKey(head)){
            return map.get(head);
        }else {
            RandomListNode res = new RandomListNode(head.label);
            map.put(head,res);
            res.random = deepCopy(head.random,map);
            res.next = deepCopy(head.next,map);
            return res;
        }
    }
}
