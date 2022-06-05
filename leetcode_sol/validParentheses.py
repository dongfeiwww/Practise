# /*
# Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

# The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
# */
# public class Solution {
#     public boolean isValid(String s) {
#         // Start typing your Java solution below
#         // DO NOT write main() function
#         if(s==null||s.length()==0) return true;
#         Stack stack=new Stack();
#         for(int i=0;i<s.length();i++){
#             if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[') stack.push(s.charAt(i));
#             else if((s.charAt(i)==')'||s.charAt(i)=='}'||s.charAt(i)==']')&&!stack.empty()){
#                char cur=stack.peek().toString().charAt(0);
#                if((cur=='('&&s.charAt(i)==')')||(cur=='{'&&s.charAt(i)=='}')||(cur=='['&&s.charAt(i)==']')) stack.pop();
#                else return false;            
#             }else return false;
#         }
#         return stack.empty();
#     }
# }

stack = []
def isBalances(stack, input):
    # print("input", stack, input)
    if not input:
        print("input", not stack, input)
        return not stack

    pair_map = {")": "(", "]": "[", "}": "{"}

    for i in range(len(input)):
        b = input[i]
        if b in ("(", "[", "{"):
            stack.append(b)
        elif b in (")", "]", "}"):
            if stack:
                if b in pair_map and pair_map[b] == stack[-1]:
                    stack.pop()
                else:
                    return False
        else:
		    # push
            for c in ("(", "[", "{"):
                stack.append(c)
                if isBalances(stack, input[i+1:]):
                    return True
                stack.pop()
            # pop
            if stack:
                stack.pop()
                if isBalances(stack, input[i+1:]):
                    return True
            return False
    return not stack

if __name__ == '__main__':
    # input="{?"
    # print(isBalances(stack, input))
    # input="{?)}"
    # print(isBalances(stack, input))
    # input="{??"
    input="?"
    print(isBalances(stack, input))