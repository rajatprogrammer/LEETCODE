/**
 * @param {string} pattern
 * @param {string} str
 * @return {boolean}
 */
var wordPattern = function(pattern, str) {
    let hash = new Map();
    let reversehash = new Map();
    let str1 = str.split(" ");
    if(str1.length!=pattern.length){
        return false;
    }
    for(let i=0;i<pattern.length;i++){
        if(reversehash.has(str1[i])){
            if(reversehash.get(str1[i])!=pattern.charAt(i)){
                return false;
            }
        }else{
            reversehash.set(str1[i],pattern.charAt(i)); 
        }
        if(hash.has(pattern.charAt(i))){
            if(str1[i]!=hash.get(pattern.charAt(i))){
                return false;
            }
        }else{
             hash.set(pattern.charAt(i),str1[i]);   
        }
    }
    return true;
};


console.log(wordPattern("abbacc","dog cat cat dog cat cat"));