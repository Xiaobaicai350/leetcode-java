select user_id from cv_test where user_id in (select user_id from user_deliver group by user_id having sum(deliver_num)>10) and score>75;
--同理
SELECT cv.user_id
FROM cv_test cv, user_deliver ud
WHERE cv.user_id = ud.user_id
AND cv.score > 75
GROUP BY cv.user_id
HAVING SUM(ud.deliver_num) > 10;