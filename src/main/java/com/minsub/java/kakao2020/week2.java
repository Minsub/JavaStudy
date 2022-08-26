package com.minsub.java.kakao2020;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class week2 {
    
    @Test
    public void test1() {
        String s = "SELECT y.profile_id as profile_id, y.referer as referer, COUNT(DISTINCT user_id) as count "
                + "FROM ( "
                + "  SELECT x.profile_id, user_id, CASE WHEN (" +
                "x.referer IN (" +
                "'RC01','A004','CE001','RC04','RC05','E002','E005','E006','R001','F001','F020','IS01', " +
                "'KAPI','KAPI-API','KAPI-AGREEMENT','KAPI-SYNC','kakao_abroad','kakao_reward','kakaopay','kakaogame', 'kakao_view', 'talk_global_search' " +
                "'PLUG', 'talk_order', 'checkout', 'PF01', 'S037', 'RC08', " +
                "'follow_channel')) THEN x.referer ELSE 'ETC' END as referer "
                + "  FROM ( "
                + "    SELECT log_values['profile_id'] AS profile_id "
                + "        , log_values['talk_user_id'] AS user_id "
                + "        , reverse(split(reverse(regexp_replace(log_values['referer'], '/RC11$$', '')), '/')[0]) as referer "
                + "    FROM rocket.maelstrom_logs "
                + "    WHERE topic_id = 'ibiza_plus_app_access' "
                + "      AND date_id = ? "
                + "      AND log_values['action'] = 'friend' "
                + "      AND log_values['friend_action'] = 'add' "
                + "    ) x "
                + ") y "
                + "GROUP BY y.profile_id, y.referer ";
    
        System.out.println(s);
    }
}
