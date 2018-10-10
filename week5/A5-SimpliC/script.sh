#script to rename all files from .out to .expected
for file in *.out; do mv -- "${file}" "${file/%out/expected}"; done
