import java.util.*;

class Solution86
{


    public int scoreOfStudents(String s, int[] answers)
    {

        int slen=s.length();
        Stack<Integer>stack=new Stack<>();
        for (char c:s.toCharArray())
        {

            if (c!='*'&&c!='+')
            {
                if (!stack.isEmpty()&&stack.peek()==-1)
                {
                    stack.pop();
                    int no=stack.pop();
                    stack.push((c-'0')*no);
                }
                else
                {
                    stack.push(c-'0');
                }
            }
            else if (c=='*')
            {
                stack.push(-1);
            }
            else
            {
                stack.push(-2);
            }
        }
        int ans=0;
        while (!stack.isEmpty())
        {
            if (stack.peek()==-2)
            {
                stack.pop();
            }
            else {
                ans+=stack.pop();

            }
        }
        HashSet<Integer>dp[][]=new HashSet[slen][slen];
        for (int i=0;i<slen;i++)
        {
            for (int j=0;j<slen;j++)
            {
                dp[i][j]=new HashSet<>();
            }
        }
        for (int i=0;i<slen;i+=2)
        {
            dp[i][i].add(s.charAt(i)-'0');
        }
        for (int diff=2;diff<slen;diff+=2)
        {
            for (int i=0;i<=slen-diff;i+=2)
            {
                int j=i+diff;
                for (int k=i+1;k<j;k++)
                {
                    if (s.charAt(k)=='+')
                    {
                        HashSet<Integer>left=dp[i][k-1];
                        HashSet<Integer>right=dp[k+1][j];
                        for (int ele:left)
                        {
                            for (int next:right) {
                                int res = ele + next;
                                if (res <= 1000) {
                                    dp[i][j].add(ele + next);
                                }
                            }
                        }
                    }
                    else
                    {
                        HashSet<Integer>left=dp[i][k-1];
                        HashSet<Integer>right=dp[k+1][j];
                        for (int ele:left)
                        {
                            for (int next:right) {
                                int res = ele * next;
                                if (res <= 1000) {
                                    dp[i][j].add(ele * next);
                                }
                            }
                        }
                    }
                }
            }
        }
        int fans=0;
        HashSet<Integer>set=dp[0][slen-1];
        for (int ele:answers)
        {
            if (ele==ans)
            {
                fans+=5;
            }
            else if (set.contains(ele))
            {
                fans+=2;
            }

        }
        return fans;
    }
//    List<Integer > helper(int left, int right, String str,List<Integer>dp[][])
//    {
//        if (left==right)
//        {
//           List<Integer>answer=new ArrayList<>();
//           answer.add(str.charAt(left)-'0');
//           return answer;
//        }
//        if (dp[left][right]!=null)
//        {
//            return dp[left][right];
//        }
//        List<Integer>answer=new ArrayList<>();
//
//        for (int i=left+1;i<right;i+=2)
//        {
//            if (str.charAt(i)=='+')
//            {
//                List<Integer> l=helper(left,i-1,str,dp);
//                List<Integer> r=helper(i+1,right,str,dp);
//                for (int ele:l)
//                {
//                    for (int next:r) {
//                        int res = ele + next;
//                        if (res <= 1000) {
//                            answer.add(ele + next);
//                        }
//                    }
//                }
//            }
//            else if (str.charAt(i)=='*')
//            {
//                List<Integer> l=helper(left,i-1,str,dp);
//                List<Integer> r=helper(i+1,right,str,dp);
//                for (int ele:l)
//                {
//                    for (int next:r)
//                    {
//                        int res = ele * next;
//                        if (res <= 1000) {
//                            answer.add(ele *next);
//                        }
//                    }
//                }
//                //return ans;
//            }
//
//        }
//        dp[left][right]=answer;
//        return answer;
//    }

}