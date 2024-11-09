class Solution {
public:
    int longestValidParentheses(string s) {
        stack <int> c;
        c.push(-1);
        int temp = 0;
        int maxx = 0;
        // for(char x: s){
        //     if(x == '('){
        //         if(!c.empty() && c.top() == '('){
        //             temp = 0;
        //             while(!c.empty()){
        //                 c.pop();
        //             }
        //         }
        //         c.push(x);
                
        //         // temp++;
                
        //     }else{
        //         if(!c.empty() && c.top() == '(' && x == ')'){
        //             c.pop();
        //             temp+=2;
        //             maxx =max(maxx, temp);
        //         }else{
        //             while(!c.empty()){
        //                 c.pop();

        //                 temp = 0;
        //             }
        //         }
        //             // maxx =max(maxx, temp);
        //     }
        // }
        // cout << maxx ; 
        // return maxx;

        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                c.push(i); 
            } else {
                c.pop(); 
                if (c.empty()) {
                    c.push(i); 
                } else {
                    
                    maxx = max(maxx, i - c.top());
                }
            }
        }
        return maxx;
    }
};