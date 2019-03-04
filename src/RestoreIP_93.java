import java.util.ArrayList;
import java.util.List;

public class RestoreIP_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        for (int a = 1;a < 4;++a)
            for (int b = 1;b < 4;++b)
                for (int c = 1;c < 4;++c)
                    for (int d = 1;d < 4;++d)
                        if (a + b + c + d == s.length()) {
                            int A = Integer.parseInt(s.substring(0, a));
                            int B = Integer.parseInt(s.substring(a, a + b));
                            int C = Integer.parseInt(s.substring(a + b, a + b + c));
                            int D = Integer.parseInt(s.substring(a + b + c));

                            if (A <= 255 && B <= 255 && C <= 255 && D <= 255) {
                                String t = A + "." + B + "." + C + "." + D;
                                if (t.length() == s.length() + 3)
                                    res.add(t);
                            }
                        }

        return res;
    }
}
