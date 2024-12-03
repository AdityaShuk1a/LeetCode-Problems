class Solution {
public:
    string addSpaces(string s, vector<int>& spaces) {
        string l = "";
        int t = 0;

        for(int i = 0; i<s.size(); i++){
            if(t >= spaces.size()){
                l+=s[i];
            }
            else if(i == spaces[t]){
                l+=" ";
                l+=s[i];
                t++;
            }else{
                l+=s[i];
            }
        }
        return l;
    }
};