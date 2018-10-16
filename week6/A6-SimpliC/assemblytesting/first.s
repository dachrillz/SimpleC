.global main 
.text
main:
    pushq %rbp
    movq %rsp, %rbp
    movl $1, %rax
    popq %rbp
    ret
    #end of main
    movq $0, %rdi       # exit code
    movq $60, %rax      # sys_exit
    syscall
