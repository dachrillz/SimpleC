main:
  pushq %rbp
  movq %rsp, %rbp
  movl $0, %rax
  call f
  movl $1, %rax
  popq %rbp
  #end of main
  movq $0, %rdi       # exit code
  movq $60, %rax      # sys_exit
  syscall
f:
  pushq %rbp
  movq %rsp, %rbp
  movl $2, %rax
  popq %rbp
  ret

