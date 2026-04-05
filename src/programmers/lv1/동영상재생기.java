package programmers.lv1;

public class 동영상재생기 {
    class Solution {
        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            int tran_video_len = tranSecond(Integer.parseInt(video_len.substring(0, 2)), Integer.parseInt(video_len.substring(3, 5)));
            int tran_pos = tranSecond(Integer.parseInt(pos.substring(0, 2)), Integer.parseInt(pos.substring(3, 5)));
            int tran_op_start = tranSecond(Integer.parseInt(op_start.substring(0, 2)), Integer.parseInt(op_start.substring(3, 5)));
            int tran_op_end = tranSecond(Integer.parseInt(op_end.substring(0, 2)), Integer.parseInt(op_end.substring(3, 5)));

            for (String command : commands) {
                if (tran_pos >= tran_op_start && tran_pos <= tran_op_end) {
                    tran_pos = tran_op_end;
                }

                switch (command) {
                    case "next":
                        if (tran_pos + 10 < tran_video_len) {
                            tran_pos += 10;
                        } else {
                            tran_pos = tran_video_len;
                        }
                        break;

                    case "prev":
                        if (tran_pos - 10 < 0) {
                            tran_pos = 0;
                        } else {
                            tran_pos -= 10;
                        }
                        break;
                }

                if (tran_pos >= tran_op_start && tran_pos <= tran_op_end) {
                    tran_pos = tran_op_end;
                }
            }

            return tranString(tran_pos);
        }

        private int tranSecond(int minute, int second) {
            return minute * 60 + second;
        }

        private String tranString(int tran_pos) {
            int minute = tran_pos / 60;
            int second = tran_pos % 60;

            return String.format("%02d:%02d", minute, second);
        }
    }
}
