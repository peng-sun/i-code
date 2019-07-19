To manually add VS Code to your path, you can run the following commands:

```
cat << EOF >> ~/.bash_profile
# Add Visual Studio Code (code)
export PATH="\$PATH:/Applications/Visual Studio Code.app/Contents/Resources/app/bin"
EOF
```
Start a new terminal to pick up your .bash_profile changes.

Note: The leading slash \ is required to prevent $PATH from expanding during the concatenation. Remove the leading slash if you want to run the export command directly in a terminal.
