import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*; 
import javax.swing.BorderFactory; 
import javax.swing.border.EtchedBorder; 

public class MenuOptions extends JFrame 
{
  private JLabel statustext; 

  public MenuOptions()
  {
    JMenuBar menubar = new JMenuBar();

    // set up File menu 
    JMenu file = new JMenu( "File" );
    file.setMnemonic( KeyEvent.VK_F );

    // set up an image for each menu item 
    ImageIcon iconNew  = new ImageIcon( getClass().getResource( "new.png" ));
    ImageIcon iconOpen = new ImageIcon( getClass().getResource( "open.png" ));
    ImageIcon iconSave = new ImageIcon( getClass().getResource( "save.png" ));
    ImageIcon iconExit = new ImageIcon( getClass().getResource( "exit.png" ));

    // set up menu item with submenus
    JMenu fileView = new JMenu( "View" );
    fileView.setMnemonic( KeyEvent.VK_V );
    JMenuItem zoomi = new JMenuItem( "Zoom in ..." );
    JMenuItem zoomo = new JMenuItem( "Zoom out ..." );
    fileView.add( zoomi );
    fileView.add( zoomo );

    // set up other menu items under File 
    JMenuItem fileNew  = new JMenuItem( "New",  iconNew );
    fileNew.setMnemonic( KeyEvent.VK_N );
    fileNew.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_N, ActionEvent.CTRL_MASK ));

    JMenuItem fileOpen = new JMenuItem( "Open", iconOpen );
    fileOpen.setMnemonic( KeyEvent.VK_O );
    fileOpen.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_O, ActionEvent.CTRL_MASK ));

    JMenuItem fileSave = new JMenuItem( "Save", iconSave );
    fileSave.setMnemonic( KeyEvent.VK_S );
    fileSave.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.CTRL_MASK ));

    JMenuItem fileExit = new JMenuItem( "Exit", iconExit );
    fileExit.setMnemonic( KeyEvent.VK_X );
    fileExit.setToolTipText( "Exit application" );
    fileExit.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_X, ActionEvent.CTRL_MASK ));
    fileExit.addActionListener( new ActionListener() 
    {
      public void actionPerformed( ActionEvent event ) 
      {
        System.exit( 0 );
      } 
    });
    file.add( fileNew  );
    file.add( fileOpen );
    file.addSeparator(); 
    file.add( fileView );
    file.addSeparator(); 
    file.add( fileSave );
    file.add( fileExit );

    // initialize status bar 
    statustext = new JLabel( "Display Progress Text in Application" ); 
    statustext.setBorder( BorderFactory.createEtchedBorder( EtchedBorder.RAISED ));

    // set up Progress menu 
    JMenu progress = new JMenu( "Progress" );
    progress.setMnemonic( KeyEvent.VK_P );

    JCheckBoxMenuItem pbar = new JCheckBoxMenuItem( "Show Progress" );
    pbar.setState( true ); 
    pbar.addActionListener( new ActionListener()
    {
      // when clicked, set status to the opposite value to what it currently is
      public void actionPerformed( ActionEvent event )
      {
        if( statustext.isVisible() )
          statustext.setVisible( false );
        else 
          statustext.setVisible( true );
       
      }
    });
    progress.add( pbar );

    // add File menu
    menubar.add( file );
    menubar.add( progress );

    // set frame attributes
    setJMenuBar( menubar );
    add( statustext, BorderLayout.SOUTH );
    setTitle( "Basic menu" );
    setSize( 300, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( EXIT_ON_CLOSE );
  }

  public static void main( String[] args ) 
  {
    MenuOptions ex = new MenuOptions();
    ex.setVisible( true );
  }
}

