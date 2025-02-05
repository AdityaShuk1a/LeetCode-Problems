class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        if(s1 == s2){
            return true;
        }
        if(s1.size() != s2.size()){
            return false;
        }
        if(s1.size() == 1 && s2.size() == 1 && s1!=s2){
            return false;
        }
        int k = 0;
        int j = 0;
        int checkNotEqual = 0;
        for(int i = 0; i<s1.size(); i++){
            if(s1[i] != s2[i]){
                checkNotEqual++;

                if(checkNotEqual == 1){
                    k = i; 
                }
                else if(checkNotEqual == 2){
                    j = i; 
                }
            } 
            cout << checkNotEqual;
            cout << s1[i] << endl;
            if(checkNotEqual > 2) return false;
        }
        cout << s1[k] << " " <<  s2[k] << " " << s1[j] << " " << s2[j]; 
        if(checkNotEqual == 2 && s1[k] == s2[j] && s1[j] == s2[k]) return true;

        return false;
    }
};