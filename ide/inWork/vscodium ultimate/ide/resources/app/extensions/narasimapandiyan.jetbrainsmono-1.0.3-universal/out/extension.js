"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.deactivate = exports.activate = void 0;
const vscode = require("vscode");
const util_1 = require("./util");
async function activate(context) {
    // Use globalThis.console for Node.js compatibility
    globalThis.console.log(`Congratulations, your extension "${context.extension.packageJSON.displayName}" installed!`);
    (0, util_1.firstTimeActivation)(context);
    const activateCommand = vscode.commands.registerCommand("jetbrainsmono.activate", () => (0, util_1.JBMActivation)(context));
    const deactivateCommand = vscode.commands.registerCommand("jetbrainsmono.deactivate", () => (0, util_1.deactivateJBM)(context));
    context.subscriptions.push(activateCommand, deactivateCommand);
}
exports.activate = activate;
function deactivate(context) {
    (0, util_1.deactivateJBM)(context);
}
exports.deactivate = deactivate;
//# sourceMappingURL=extension.js.map