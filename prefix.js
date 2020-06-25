var isPrefixOfWord = function (sentence, searchWord) {
    let space = 1;
    let x = 0;
    for (let i = 0; i < sentence.length; i++) {
        if (sentence[i] == searchWord[x]) {
            x = x + 1;
            continue;
        }
        if (sentence[i] == ' ') {
            space = space + 1;
            x = 0;
        }
        if (x == searchWord.length - 1) {
            return space
        }
    }
    return -1;

};



console.log(isPrefixOfWord("i love eating burger", "burg"));