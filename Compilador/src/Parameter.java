public class Parameter {
    private String name;    // Nombre del parámetro
    private String type;    // Tipo del parámetro (ej: "int", "float")

    public void validateParameters(String funcName, List<ExpressionType> args) {
        FunctionEntry func = getFunction(funcName);
        List<Parameter> params = func.getParameters();

        if (args.size() != params.size()) {
            throw new SemanticError("Número incorrecto de argumentos para '" + funcName + "'.");
        }

        for (int i = 0; i < args.size(); i++) {
            String argType = args.get(i);
            String paramType = params.get(i).getType();
            if (!isCompatible(argType, paramType)) {
                throw new SemanticError("Tipo inválido en argumento " + (i+1) + " de '" + funcName + "'.");
            }
        }
    }
}