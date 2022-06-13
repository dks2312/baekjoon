#include <iostream>

using namespace std;
 
char chessBoard[50][51];

int Search(char firstColor, int i, int j){
    int change = 0;
    char tileTemp;

    for(int iTemp = 0; iTemp < 8; iTemp++){
        for(int jTemp = 0; jTemp < 8; jTemp++){
            tileTemp =  chessBoard[i + iTemp][j + jTemp];

            if(jTemp % 2 == 0 && tileTemp != firstColor || 
               jTemp % 2 == 1 && tileTemp == firstColor) {
                change++;
            }
        }
    
        if(firstColor == 'B') firstColor = 'W';
        else firstColor = 'B';
    }

    return change;
}

int Solution(int N, int M){
    int change, MinChange = 64;

    cin.get();
    for(int i = 0; i < N; i++){
        cin.getline(chessBoard[i], 51);
    }

    for(int i = 0; i <= N - 8; i++){
        for(int j = 0; j <= M - 8; j++){
            change = Search('B', i, j);
            if(change < MinChange) MinChange = change;
            
            change = Search('W', i, j);
            if(change < MinChange) MinChange = change;
        }
    }

    return MinChange;
}

int main(){
    int N, M;

    cin >> N >> M;

    cout << Solution(N, M);

    return 0;
}