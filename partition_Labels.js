/**
 * @param {string} S
 * @return {number[]}
 */
var partitionLabels = function(S) {
    let output=[]
    let hash = new Map();

    for(let itr=0;itr<S.length;itr++){
        debugger;
         hash.set(S[itr],itr);
    };
    hash.forEach((value,key)=>{
        console.log("value" + value + "key" + key);
    })
    for(let itr=0;itr<S.length;itr++){
        let in1=hash.get(S[itr]);
        if(in1==itr){
            output.push(((itr-in1)+1));
        }
    }
    return output;

};

console.log(partitionLabels("ababcbacadefegdehijhklij"))