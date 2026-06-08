class Solution {
    /**
     * @param {string[]} strs
     * @returns {string}
     */
    encode(strs) {
        return strs.length === 0 ? "///emptycode###" : strs.join("///endhere###");
    }

    /**
     * @param {string} str
     * @returns {string[]}
     */
    decode(str) {
        return str === "///emptycode###" ? [] : str.split("///endhere###");
    }
}
