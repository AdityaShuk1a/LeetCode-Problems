class Solution {
public:
    bool isPalindrome(string s) {
        
        string neww = "";
        
         for(int i = 0; i<s.size(); i++){
            if(isdigit(s[i]) || isalpha(s[i])){
                neww+=tolower(s[i]);
            }
         }

        //  if(neww.size() == 1){
        //     return false;
        //  }
         cout << neww << endl;
         for(int i = 0; i<neww.size()/2; i++){
            if(neww[i] != neww[neww.size()-i-1]){
                return false;
            }
         }
         return true;
    }
};