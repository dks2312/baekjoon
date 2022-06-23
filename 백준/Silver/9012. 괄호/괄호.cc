#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main()
{
    int count;
    
    cin >> count;
    for(int i = 0; i < count; i++){
        string temp;
        int brackeCount = 0;
        cin >> temp;

        for(char bracket : temp){
            if(bracket == '('){
                brackeCount++;
            }
            else{
                brackeCount--;

                if(brackeCount < 0)
                    break;
            }
        }

        string message = brackeCount == 0 ? "YES" : "NO";
        cout << message << endl;
    }

    return 0;
}