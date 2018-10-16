.global _start
_start:
main:	# main
	pushq %rbp
	movq %rsp, %rbp
	call f
	movq %rbp, %rsp
	popq %rbp
	#End of Main
	#Syscall
	movq $0, %rdi	#exit_code
	movq $60, %rax	#sys_exit
	syscall
f:	# f
	pushq %rbp
	movq %rsp, %rbp
	movq $2 , %rax
	movq %rbp, %rsp
	popq %rbp
	ret
