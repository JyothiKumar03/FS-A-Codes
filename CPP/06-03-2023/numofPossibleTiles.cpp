/*
There are some cubes, each cube is printed with an alphabet [A-Z].
Using these cubes, you can create non-empty distinct words.
and length of the words should be 0< length <= no.of.cubes.

You are given a string of alphabets S, 
Your task is to findout number of possible non-empty distinct words

Input Format:
-------------
A string S, consist of A-Z letters only.

Output Format:
--------------
Print an integer, number of possible non-empty distinct words.


Sample Input-1:
---------------
EGG

Sample Output-1:
----------------
8

Explanation:
--------------
The possible distinct words are "E", "G", "EG", "GG", "GE", "EGG", "GEG", "GGE".


Sample Input-2:
---------------
MADAM

Sample Output-2:
----------------
89

*/

#include <bits/stdc++.h>
using namespace std;

void allPossibleTiles(string &s,string sub,vector<bool> vis,set<string>& st){
    if(sub.size()>0){
        if(st.find(sub)!=st.end()){
            return;
        }
        st.insert(sub);
    }
    //because we want all possible strings in different sizes and arrangements, iterate
    for(int i=0;i<s.size();i++){
        if(vis[i]){
            continue;
        }
        vis[i] = true;
        allPossibleTiles(s,sub+s[i],vis,st);
        vis[i] = false;
    }
}

int main(){
    string s;
    cin>>s;
    set<string> st;
    int n = s.size();
    vector<bool> vis(n,false);
    allPossibleTiles(s,"",vis,st);
    int res = st.size();
    cout<<res<<endl;
}
