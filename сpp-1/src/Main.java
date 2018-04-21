
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;

/**
 * Program for checking leap-year.
 * @author MossyChuck
 *
 */
public class Main {
    /**
     * Main method. Builds GUI.
     * @param args CL parameters
     */
    public static void main(final String[] args) {
        new Main().build();
    }

    private Label yearLabel;
    private Label answerLabel;
    private Text textField;
    private Label dayInYearLabel;
    private static final int DAY_IN_YEAR_LABEL_WIDTH = 130;
    private static final int BUTTON_WIDTH = 100;
    private static final int ANSWER_LABEL_WIDTH = 100;

    /**
     * Builds GUI.
     */
    public void build() {
        Display display = new Display();

        Shell mainShell = new Shell(display);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        mainShell.setLayout(layout);
        Composite composite = new Composite(mainShell, SWT.LEFT);
        composite.setLayout(new RowLayout());

        yearLabel = new Label(composite, SWT.PUSH);
        yearLabel.setText("Year ");
        textField = new Text(composite, SWT.BORDER);
        Composite dayInYearLabelComposite = new Composite(mainShell, SWT.LEFT);
        dayInYearLabelComposite.setLayout(new GridLayout());
        GridData gdDayInYearLabel = new GridData(GridData.FILL_BOTH);
        gdDayInYearLabel.widthHint = DAY_IN_YEAR_LABEL_WIDTH;
        dayInYearLabel = new Label(dayInYearLabelComposite, SWT.PUSH);
        dayInYearLabel.setText("Days: ?");
        dayInYearLabel.setLayoutData(gdDayInYearLabel);
        Composite buttonComposite = new Composite(mainShell, SWT.LEFT);
        buttonComposite.setLayout(new GridLayout());
        GridData gdButton = new GridData(GridData.FILL_BOTH);
        gdButton.widthHint = BUTTON_WIDTH;
        Button button = new Button(buttonComposite, SWT.PUSH);
        button.setLayoutData(gdButton);
        button.setText("Check");
        Composite answerLabelComposite = new Composite(mainShell, SWT.LEFT);
        answerLabelComposite.setLayout(new GridLayout());
        GridData gdAnswerLabel = new GridData(GridData.FILL_BOTH);
        gdAnswerLabel.widthHint = ANSWER_LABEL_WIDTH;
        answerLabel = new Label(answerLabelComposite, SWT.PUSH);
        answerLabel.setText("Leap year: ?");
        answerLabel.setLayoutData(gdAnswerLabel);


        //register listener for the selection event
        button.addSelectionListener(new ButtonSelectionListener());

        Button clearButton = new Button(mainShell, SWT.PUSH);
        clearButton.setText("Clear");
        clearButton.addSelectionListener(new ClearButtonSelectionListener());
        // set widgets size to their preferred size
        mainShell.pack();
        mainShell.open();
        while (!mainShell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
    
    class ClearButtonSelectionListener implements SelectionListener{

		@Override
		public void widgetSelected(SelectionEvent e) {
			textField.setText("");
			
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			
		}
    	
    }

    /**
     * Inner class for button SelectionListener.
     * @author nikkonrom
     *
     */
    class ButtonSelectionListener implements SelectionListener {

        /**
         * Button click event handler.
         */
        @Override
        public void widgetSelected(final SelectionEvent e) {
            try {
                int year = Integer.parseInt(textField.getText());
                if (checkYear(year)) {
                    answerLabel.setText("Leap year: yes");
                    dayInYearLabel.setText("Days: 366");
                } else {
                    answerLabel.setText("Leap year: no");
                    dayInYearLabel.setText("Days: 365");
                }

            } catch (NumberFormatException exception) {
                answerLabel.setText("Leap year: ?");
            }

        }

        private static final int CHECK_1 = 400;
        private static final int CHECK_2 = 100;
        private static final int CHECK_3 = 4;

        /**
         * Checks year for leap-year.
         * @param year year for check
         * @return true if year is leap-year, false if not
         */
        public boolean checkYear(final int year) {
            return (year % CHECK_1 == 0)
                    || (year % CHECK_2 != 0 &&  year % CHECK_3 == 0);
        }

        /**
         * Default handler (Not used?).
         */
        @Override
        public void widgetDefaultSelected(final SelectionEvent e) {

        }

    }
}
