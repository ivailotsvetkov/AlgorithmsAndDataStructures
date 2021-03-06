package expressions;

public abstract class UnaryExpression implements Expression
{
   private Expression child;

   public UnaryExpression(Expression child)
   {
      this.child = child;
   }

   public Expression getChild()
   {
      return child;
   }

   @Override
   public double getValue()
   {
      return child.getValue();
   }
}
