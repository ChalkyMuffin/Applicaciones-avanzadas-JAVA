public class VariableEntry {
    private String name;    // Nombre de la variable
    private String type;    // Tipo de dato (ej: "int", "float")
    private String scope;   // Ámbito (ej: "global", "funcion1")


    public void addVariable(String name, String type) {
        Map<String, VariableEntry> currentScope = variableTables.peek();
        if (currentScope.containsKey(name)) {
            throw new SemanticError("Variable '" + name + "' ya declarada en este ámbito.");
        }
        currentScope.put(name, new VariableEntry(name, type, getCurrentScopeName()));
    }

    public VariableEntry findVariable(String name) {
        // Busca desde el ámbito actual hacia arriba
        for (int i = variableTables.size() - 1; i >= 0; i--) {
            Map<String, VariableEntry> scope = variableTables.get(i);
            if (scope.containsKey(name)) {
                return scope.get(name);
            }
        }
        throw new SemanticError("Variable '" + name + "' no declarada.");
    }

    public void enterScope() {
        variableTables.push(new HashMap<>());
    }

    public void exitScope() {
        if (!variableTables.isEmpty()) {
            variableTables.pop();
        }
    }

    public void validateAssignment(String varName, String valueType) {
        VariableEntry var = findVariable(varName);
        if (!isCompatible(valueType, var.getType())) {
            throw new SemanticError("No se puede asignar " + valueType + " a " + var.getType() + " '" + varName + "'.");
        }
    }
}
