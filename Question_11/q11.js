function checkTextPalindrome(inputStr) {

    const cleanedStr = inputStr.toLowerCase();
  
    const reversedStr = cleanedStr.split('').reverse().join('');
  
    return cleanedStr === reversedStr;
  
  }
  
  
  
  console.log(checkTextPalindrome("repaper"));
  
  console.log(checkTextPalindrome("pillow"));
  
  console.log(checkTextPalindrome("book"));
  
  console.log(checkTextPalindrome("A man, a plan, a canal: Panama"));
  
  console.log(checkTextPalindrome("No lemon, no melon"));