public class FunctionEntry {
    private String name;          // Nombre de la función
    private String returnType;    // Tipo de retorno (ej: "int", "void")
    private List<Parameter> parameters; // Lista de parámetros
    private Map<String, VariableEntry> localVariables; // Variables locales
    // Otros campos como dirección de memoria (si es necesario)

    public void addFunction(String name, String returnType, List<Parameter> params) {
        if (functionDirectory.containsKey(name)) {
            throw new SemanticError("Función '" + name + "' ya declarada.");
        }
        FunctionEntry newFunc = new FunctionEntry(name, returnType, params);
        functionDirectory.put(name, newFunc);
    }

    //Buscar funcion
    public FunctionEntry getFunction(String name) {
        FunctionEntry func = functionDirectory.get(name);
        if (func == null) {
            throw new SemanticError("Función '" + name + "' no declarada.");
        }
        return func;
    }



    public void addLocalVariable(String funcName, String varName, String type) {
        FunctionEntry func = getFunction(funcName);
        Map<String, VariableEntry> locals = func.getLocalVariables();
        if (locals.containsKey(varName)) {
            throw new SemanticError("Variable local '" + varName + "' ya declarada en '" + funcName + "'.");
        }
        locals.put(varName, new VariableEntry(varName, type, funcName));
    }
}