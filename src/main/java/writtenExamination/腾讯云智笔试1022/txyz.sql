select user_id from cv_test where user_id in (select user_id from user_deliver group by user_id having sum(deliver_num)>10) and score>75;