/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function (board, word) {
    word = word.split('');
    let visited = new Array(board.length);
    for (var i = 0; i < visited.length; i++) {
        visited[i] = new Array(board[0].length);
    }
    for (let i = 0; i < board.length; i++) {

        for (let j = 0; j < board[0].length; j++) {
            visited[i][j] = false;
        }
    }
    let status = false;
    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[0].length; j++) {
            if (!visited[i][j] && board[i][j] == word[0]) {
                status = search(board, i, j, word, 0);
                if (status == true) {
                    break;
                }
            }
        }
        if (status == true) {
            break;
        }
    }
    return status;
};

function search(board, i, j, char, charIndex) {
    if (charIndex >= char.length) {
        return true;
    }
    if (!isSafe(board, i, j, char[charIndex])) {
        return false;
    };
    let temp = board[i][j];
    board[i][j] = '--';
    let l1 = search(board, i + 1, j, char, charIndex + 1);
    let l2 = search(board, i, j + 1, char, charIndex + 1);
    let l3 = search(board, i - 1, j, char, charIndex + 1);
    let l4 = search(board, i, j - 1, char, charIndex + 1);
    board[i][j] = temp;
    return (l1 || l2 || l3 || l4);
}

function isSafe(board, i, j, c) {
    // debugger;
    if (i >= board.length || i <= -1 || j >= board[0].length || j <= -1 || board[i][j] != c) {
        return false;
    } else {
        return true;
    }
}


console.log(exist([
    ['A', 'B', 'C', 'E'],
    ['S', 'F', 'C', 'S'],
    ['A', 'D', 'E', 'E']
], 'ABCB'));