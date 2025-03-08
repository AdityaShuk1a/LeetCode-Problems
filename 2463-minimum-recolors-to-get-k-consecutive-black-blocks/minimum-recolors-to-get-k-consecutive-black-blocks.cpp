class Solution {
public:
    int minimumRecolors(string blocks, int k) {
        int minimumColors = INT_MAX;

        string s = "";

        int errors = 0;

        for(int i = 0; i < k; i++){
            s+=blocks[i];
            if(blocks[i] == 'W'){
                errors++;
            }

        }
        // cout << errors << endl;
        minimumColors = min(errors, minimumColors);

        for(int i = k; i < blocks.size(); i++){
            if(s[0] == 'W' && blocks[i] == 'B'){
                errors--;
            }else if(s[0] == 'B' && blocks[i] == 'W'){
                errors++;
            }
            string temp = s.substr(1, s.size());
            temp+=blocks[i];
            s = temp;
            cout << s << endl;
            minimumColors = min(errors, minimumColors);
           
        }
        
        return minimumColors;
    }
};